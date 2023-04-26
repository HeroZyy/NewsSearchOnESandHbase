<template>
  <div class="container">
    <div class="search-box">
      <el-input v-model="searchContent.content" class="search" size="large"  clearable placeholder="请输入查询内容"></el-input>
<!--      <el-button @click="refresh" >再搜一次</el-button>-->
      <el-button @click="searchFun">搜索</el-button>
    </div>

    <el-scrollbar height="1000px" >
      <el-space direction="vertical">
        <el-card class="box-card" v-for="i in resultContent.count" :key="i" >
          <template #header>
            <div class="card-header">
<!--              <span>{{i}}<br></span>-->
                <el-dropdown>
                  <el-button type="primary" @mouseover="HBaseSearch(idSearch.str[i-1])">
                    查看详细信息<el-icon class="el-icon--right"><arrow-down /></el-icon>
                  </el-button>
                  <template #dropdown>
                    <el-dropdown-menu>
                       <el-dropdown-item v-model="contentData.content">{{contentData.content}}</el-dropdown-item>
                    </el-dropdown-menu>
                  </template>
                </el-dropdown>
            </div>
          </template>
          <div  class="text item">
            {{"标题: "+ title.str[i - 1] }}<br>
            {{"概括: "+ describe.str[i - 1] }}<br>
            {{"关键词: "+ describe.str[i-1]}}<br>
            {{"频道:" +   author.str[i-1]}}<br>
            {{"时间:" +   time.str[i-1]}}<br>

          </div>
        </el-card>
      </el-space>
    </el-scrollbar>
  </div>
</template>


<script setup lang="ts">
import { ref, reactive ,toRefs  } from 'vue';
import { useTagsStore } from '../store/tags';
import { usePermissStore } from '../store/permiss';
import { useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';
import type { FormInstance, FormRules } from 'element-plus';
import { defineComponent } from 'vue'
import { ElConfigProvider } from 'element-plus'
import axios from 'axios'
import { Lock, User } from '@element-plus/icons-vue';

interface ResultInfo{
  title:    Array<string>;
  id:       Array<string>;
  describe: Array<string>;
  content:  Array<string>;
  time:     Array<string>;
  author:   Array<string>;
  list:     Array<string>;
  pageSize: number;
  currentPage: number;
  count: number;
}

const countLen = reactive({count:100});
const router = useRouter();

const rules: FormRules = {
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur'
    }
  ],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
};
let searchContent = reactive({content:"1"});
let contentData = reactive({content:""});
let resultContent = reactive<ResultInfo>({
  title:    [],
  id:       [],
  describe: [],
  content:  [],
  time:     [],
  author:   [],
  list:     [],
  pageSize:  1,
  currentPage: 10,
  count: 0,
});
let title    = reactive({str:[]})
let idSearch = reactive({str:[]})
let describe = reactive({str:[]})
let content  = reactive({str:[]})
let time     = reactive({str:[]})
let author   = reactive({str:[]})
let list     = reactive({str:[]})
// let currentPage = ref(1)
// let pageSize
const permiss = usePermissStore();
const login = ref<FormInstance>();
const HBaseSearch = (i) => {
  axios.get('http://localhost:8081/detailArticleById', {
    params: {
      id: `${i}`
    },
    headers: {
      // remove headers
    }
    }).then(response => {
      // alert(response.data["content"])
      contentData.content = response.data["content"]
    });
}

const searchFun = () => {
  axios.get('http://localhost:8081/article', {
    params: {
      key: searchContent.content,
    },
    headers: {
      // remove headers
    }
  }).then(response => {
        resultContent.title=[]
        resultContent.describe=[]
        resultContent.author=[]
        resultContent.time=[]
        resultContent.id=[]
        resultContent.count = response.data["count"] - 1
        if(resultContent.count > 101) resultContent.count = 100;
        if(resultContent.count < 0) resultContent.count = 1;
        for (var i = 0; i < resultContent.count; i++) {
          resultContent.title.push(response.data.dataList[i].title)
          resultContent.describe.push(response.data.dataList[i].describe)
          resultContent.author.push(response.data.dataList[i].author)
          resultContent.time.push(response.data.dataList[i].time)
          resultContent.id.push(response.data.dataList[i].id)
        }
        title   .str = resultContent.title
        idSearch.str = resultContent.id
        describe.str = resultContent.describe
        content .str = resultContent.content
        time    .str = resultContent.time
        author  .str = resultContent.author
        console.log(describe.str)
      })
}

const tags = useTagsStore();
tags.clearTags();
</script>
<style>
.box-card{
  width: 1200px;
}
.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}
.el-link .el-icon--right.el-icon {
  vertical-align: text-bottom;
}
</style>
