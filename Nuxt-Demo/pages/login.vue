<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import { useToast } from "@vueuse/core"

const username = ref('')
const password = ref('')
const router = useRouter()
const toast = useToast()
// const alertMessage = useAlert()

const login = () => {
  if (username.value === 'admin' && password.value === '123456') {
    // alertMessage.value = "登录成功！🎉"
    toast.add({ title: "登录成功！🎉", timeout: 2000 })
    // 登录成功后跳转到首页
    setTimeout(() => router.push("/"), 1500)
  } else {
    toast.add({ title: "用户名或密码错误", timeout: 2000 })
  }
}
</script>

<template>
  <div class="login-container">
    <h1>登录</h1>
    <form @submit.prevent="login">
      <div>
        <label for="username">用户名：</label>
        <input id="username" v-model="username" type="text" required/>
      </div>
      <div>
        <label for="password">密码：</label>
        <input id="password" v-model="password" type="password" required/>
      </div>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <button type="submit">登录</button>
    </form>
  </div>
</template>

<style scoped>
.login-container {
  max-width: 300px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
}

input {
  display: block;
  width: 100%;
  margin: 5px 0;
  padding: 8px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #42b883;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.error {
  color: red;
}
</style>