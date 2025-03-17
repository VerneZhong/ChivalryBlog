<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import { useToast } from "vue-toastification"
import axios from 'axios'

const username = ref('')
const password = ref('')
const router = useRouter()
const toast = useToast()


// const login = () => {
//   if (username.value === 'admin' && password.value === '123456') {
//     toast.success("登录成功！🎉", { timeout: 2000 })
//     // 登录成功后跳转到首页
//     setTimeout(() => router.push("/"), 1500)
//   } else {
//     toast.error("用户名或密码错误！🎉", { timeout: 2000 })
//   }
// }

const login = async () => {
  try {
    // 发起登录请求
    const response = await axios.post('http://127.0.0.1/api/login', {
      username: username.value,
      password: password.value
    })

    // 假设返回数据包含一个 `token` 或 `status` 字段
    if (response.data.status === 'success') {
      toast.success("登录成功！🎉", { timeout: 2000 })
      // 登录成功后存储 token
      localStorage.setItem('auth_token', response.data.token)
      // 登录成功后跳转到首页
      setTimeout(() => router.push("/"), 1500)
    } else {
      toast.error("用户名或密码错误！🎉", { timeout: 2000 })
    }
  } catch (error) {
    // 处理请求错误（如网络问题、后端错误等）
    toast.error("网络错误，请稍后再试！", { timeout: 2000 })
  }
}
</script>

<template>
  <div class="login-container">
    <h1 class="title">欢迎登录</h1>
    <form @submit.prevent="login" class="login-form">
      <div class="form-group">
        <label for="username">用户名：</label>
        <input id="username" v-model="username" type="text" placeholder="请输入用户名" required />
      </div>
      <div class="form-group">
        <label for="password">密码：</label>
        <input id="password" v-model="password" type="password" placeholder="请输入密码" required />
      </div>
      <button type="submit" class="login-btn">登录</button>
    </form>
  </div>
</template>

<style scoped>
/* 背景和页面布局 */
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 30px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
  font-family: 'Arial', sans-serif;
}

.title {
  text-align: center;
  font-size: 2.5rem;
  color: #42b883;
  margin-bottom: 20px;
}

/* 表单和输入框样式 */
.login-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 20px;
}

label {
  font-size: 1rem;
  color: #555;
  margin-bottom: 5px;
  display: block;
}

input {
  padding: 12px 15px;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 1rem;
  width: 100%;
  outline: none;
  transition: border-color 0.3s ease;
}

input:focus {
  border-color: #42b883;
}

/* 按钮样式 */
.login-btn {
  padding: 15px;
  font-size: 1.2rem;
  background-color: #42b883;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

.login-btn:hover {
  background-color: #369d6a;
  transform: translateY(-2px);
}

.login-btn:active {
  transform: translateY(1px);
}

/* 错误信息 */
.error {
  color: red;
  font-size: 0.9rem;
  margin-top: 10px;
}

/* 响应式设计 */
@media (max-width: 480px) {
  .login-container {
    padding: 20px;
    width: 90%;
  }

  .title {
    font-size: 2rem;
  }

  .login-btn {
    font-size: 1rem;
  }
}
</style>