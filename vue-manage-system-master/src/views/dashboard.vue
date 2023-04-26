<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="8">
        <el-card shadow="hover" class="mgb20" style="height: 252px">
          <div class="user-info">
            <el-avatar :size="120" :src="imgurl"/>
            <div class="user-info-cont">
              <div class="user-info-name">{{ name }}</div>
              <div>{{ role }}</div>
            </div>
          </div>
          <div class="user-info-list">
            上次登录时间：
            <span>2023-4-27</span>
          </div>
          <div class="user-info-list">
            上次登录地点：
            <span>上海</span>
          </div>
        </el-card>
        <el-card shadow="hover" style="height: 252px">
          <template #header>
            <div class="clearfix">
              <span>语言详情</span>
            </div>
          </template>
          ElasticSearch
          <el-progress :percentage="77" color="#42b983"></el-progress>
          HBase
          <el-progress :percentage="33" color="#f1e05a"></el-progress>
          Redis
          <el-progress :percentage="33"></el-progress>
          MySQL
          <el-progress :percentage="22" color="#f56c6c"></el-progress>
        </el-card>
      </el-col>
      <el-col :span="16">
        <el-row :gutter="20" class="mgb20">
          <el-col :span="8">
            <el-card shadow="hover" :body-style="{ padding: '0px' }">
              <div class="grid-content grid-con-1">
                <el-icon class="grid-con-icon">
                  <User/>
                </el-icon>
                <div class="grid-cont-right">
                  <div class="grid-num">15</div>
                  <div>用户访问量</div>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card shadow="hover" :body-style="{ padding: '0px' }">
              <div class="grid-content grid-con-2">
                <el-icon class="grid-con-icon">
                  <ChatDotRound/>
                </el-icon>
                <div class="grid-cont-right">
                  <div class="grid-num">21561600</div>
                  <div>新闻条数</div>
                </div>
              </div>
            </el-card>
          </el-col>
          <!--					<el-col :span="8">-->
          <!--						<el-card shadow="hover" :body-style="{ padding: '0px' }">-->
          <!--							<div class="grid-content grid-con-3">-->
          <!--								<el-icon class="grid-con-icon"><Goods /></el-icon>-->
          <!--								<div class="grid-cont-right">-->
          <!--									<div class="grid-num">5000</div>-->
          <!--									<div>商品数量</div>-->
          <!--								</div>-->
          <!--							</div>-->
          <!--						</el-card>-->
          <!--					</el-col>-->
        </el-row>
        <el-card shadow="hover" style="height: 403px">
          <template #header>
            <div class="clearfix">
              <span>待办事项</span>
              <el-button style="float: right; padding: 3px 0" text>添加</el-button>
            </div>
          </template>

          <el-table :show-header="false" :data="todoList" style="width: 100%">
            <el-table-column width="40">
              <template #default="scope">
                <el-checkbox v-model="scope.row.status"></el-checkbox>
              </template>
            </el-table-column>
            <el-table-column>
              <template #default="scope">
                <div
                    class="todo-item"
                    :class="{
										'todo-item-del': scope.row.status
									}"
                >
                  {{ scope.row.title }}
                </div>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card shadow="hover">
          <schart ref="bar" class="schart" canvasId="bar" :options="options"></schart>
        </el-card>
      </el-col>
      <!--			<el-col :span="12">-->
      <!--				<el-card shadow="hover">-->
      <!--					<schart ref="line" class="schart" canvasId="line" :options="options2"></schart>-->
      <!--				</el-card>-->
      <!--			</el-col>-->
    </el-row>
  </div>
</template>

<script setup lang="ts" name="dashboard">
import Schart from 'vue-schart';
import {reactive} from 'vue';
import imgurl from '../assets/img/img.jpg';

const name = localStorage.getItem('ms_username');
const role: string = name === 'admin' ? '超级管理员' : '普通用户';

const options = {
  type: 'pie',
  title: {
    text: '新闻数据类型分类图(单位/条)'
  },
  legend: {
    position: 'left'
  },
  bgColor: '#fbfbfb',
  labels: ["生活",
    "军事",
    "国内",
    "国际",
    "经济",
    "三农",
    "社会",
    "健康",
    "科技",
    "人物",
    "农经",
    "教育",
    "法治",
    "书画",
    "文娱",],
  colorList: ["#4A90E2", "#F5A623", "#ff5858", "#5e64ff", "#2AC766", "#743ee2", "#b554ff", "#199475", "#166",
    "#266",
    "#366",
    "#466",
    "#566",
    "#666",
    "#766",
    "#866",
    "#966",
    "#a37cba",
    "#7926b6",
    "#d95b5b",
    "#b69738",
    "#69c764",
  ],
  datasets: [{
    data: [1305600,
      465600,
      2400000,
      2400000,
      345600,
      480000,
      2400000,
      2400000,
      801600,
      2496000,
      480000,
      686400,
      1392000,
      2880000,
      628800]
  }]
};
// const options2 = {
// 	type: 'line',
// 	title: {
// 		text: '最近几个月各品类销售趋势图'
// 	},
// 	labels: ['6月', '7月', '8月', '9月', '10月'],
// 	datasets: [
// 		{
// 			label: '家电',
// 			data: [234, 278, 270, 190, 230]
// 		},
// 		{
// 			label: '百货',
// 			data: [164, 178, 150, 135, 160]
// 		},
// 		{
// 			label: '食品',
// 			data: [74, 118, 200, 235, 90]
// 		}
// 	]
// };
const todoList = reactive([
  {
    title: '看新闻',
    status: false
  },{
    title: '看新闻',
    status: false
  },{
    title: '看新闻',
    status: false
  },{
    title: '看新闻',
    status: false
  }
]);
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}

.grid-content {
  display: flex;
  align-items: center;
  height: 100px;
}

.grid-cont-right {
  flex: 1;
  text-align: center;
  font-size: 14px;
  color: #999;
}

.grid-num {
  font-size: 30px;
  font-weight: bold;
}

.grid-con-icon {
  font-size: 50px;
  width: 100px;
  height: 100px;
  text-align: center;
  line-height: 100px;
  color: #fff;
}

.grid-con-1 .grid-con-icon {
  background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
  color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
  background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
  color: rgb(100, 213, 114);
}

.grid-con-3 .grid-con-icon {
  background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
  color: rgb(242, 94, 67);
}

.user-info {
  display: flex;
  align-items: center;
  padding-bottom: 20px;
  border-bottom: 2px solid #ccc;
  margin-bottom: 20px;
}

.user-info-cont {
  padding-left: 50px;
  flex: 1;
  font-size: 14px;
  color: #999;
}

.user-info-cont div:first-child {
  font-size: 30px;
  color: #222;
}

.user-info-list {
  font-size: 14px;
  color: #999;
  line-height: 25px;
}

.user-info-list span {
  margin-left: 70px;
}

.mgb20 {
  margin-bottom: 20px;
}

.todo-item {
  font-size: 14px;
}

.todo-item-del {
  text-decoration: line-through;
  color: #999;
}

.schart {
  width: 100%;
  height: 300px;
}
</style>
