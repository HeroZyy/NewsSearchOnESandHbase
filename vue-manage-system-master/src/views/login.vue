<template>
	<div class="login-wrap">
		<div class="ms-login">
			<div class="ms-title">搜索系统</div>
			<el-form :model="user" :rules="rules" ref="login" label-width="0px" class="ms-content">
				<el-form-item prop="account">
					<el-input v-model="user.account" placeholder="account">
						<template #prepend>
							<el-button :icon="user"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<el-form-item prop="passwd">
					<el-input
						type="passwd"
						placeholder="passwd"
						v-model="user.passwd"
						@keyup.enter="submitForm(login)"
					>
						<template #prepend>
							<el-button :icon="Lock"></el-button>
						</template>
					</el-input>
				</el-form-item>
				<div class="login-btn">
					<el-button type="primary" @click="submitForm(login)">登录</el-button>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue';
import { useTagsStore } from '../store/tags';
import { usePermissStore } from '../store/permiss';
import { useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';
import type { FormInstance, FormRules } from 'element-plus';
import { Lock, User } from '@element-plus/icons-vue';
import axios from "axios";

interface LoginInfo {
  account: string;
	passwd: string;
}

const router = useRouter();
const user = reactive<LoginInfo>({
  account: 'admin',
	passwd: '123456'
});
// const user = reactive({
//   account: 'admin',
//   passwd: '123456'
// });
const rules: FormRules = {
	account: [
		{
			required: true,
			message: '请输入用户名',
			trigger: 'blur'
		}
	],
	passwd: [{ required: true, message: '请输入密码', trigger: 'blur' }]
};

const permiss = usePermissStore();
const login = ref<FormInstance>();
const status = reactive({
  connect: false
});

const submitForm = (formEl: FormInstance | undefined) => {
    // console.log(user.account)
    // console.log(user.passwd)
      // axios.post('http://localhost:8081/login', {
      //   data: user
      // }, {
      //   headers: {
      //     'Content-Type': 'application/json;charset=utf-8'
      //   }
      // });


	if (!formEl) return;
	formEl.validate((valid: boolean) => {
    valid = false
    axios.get('http://localhost:8081/login', {
      params: {
        account: user.account,
        passwd: user.passwd
      },
      headers: {
        // remove headers
      }
    }).then(response => {
      valid = response.data["connect"] == "1";
      console.log(valid)

      if (valid) {
        ElMessage.success('登录成功');
        localStorage.setItem('ms_username', user.account);
        const keys = permiss.defaultList[user.account == 'admin' ? 'admin' : 'user'];
        permiss.handleSet(keys);
        localStorage.setItem('ms_keys', JSON.stringify(keys));
        router.push('/');
      }
      else {
        ElMessage.error('登陆失败');
        return false;
      }
    })


	});
};

const tags = useTagsStore();
tags.clearTags();
</script>

<style scoped>
.login-wrap {
	position: relative;
	width: 100%;
	height: 100%;
	background-image: url(../assets/img/login-bg.jpg);
	background-size: 100%;
}
.ms-title {
	width: 100%;
	line-height: 50px;
	text-align: center;
	font-size: 20px;
	color: #fff;
	border-bottom: 1px solid #ddd;
}
.ms-login {
	position: absolute;
	left: 50%;
	top: 50%;
	width: 350px;
	margin: -190px 0 0 -175px;
	border-radius: 5px;
	background: rgba(255, 255, 255, 0.3);
	overflow: hidden;
}
.ms-content {
	padding: 30px 30px;
}
.login-btn {
	text-align: center;
}
.login-btn button {
	width: 100%;
	height: 36px;
	margin-bottom: 10px;
}
.login-tips {
	font-size: 12px;
	line-height: 30px;
	color: #fff;
}
</style>
