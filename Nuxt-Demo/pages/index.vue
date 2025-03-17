<template>
  <div class="home-page">
    <div class="content-container">
      <h1 class="title">欢迎来到我的网站</h1>
      <p class="description">在这里，你可以找到最新的资讯和功能。</p>
      <NuxtLink to="/login" class="btn-login">前往登录</NuxtLink>
    </div>
  </div>
</template>

<style scoped>
.home-page {
  background: linear-gradient(135deg, #6a11cb, #2575fc);
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Arial', sans-serif;
  color: #fff;
}

.content-container {
  text-align: center;
  padding: 40px;
  background: rgba(0, 0, 0, 0.5);
  border-radius: 15px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.title {
  font-size: 3rem;
  margin-bottom: 20px;
}

.description {
  font-size: 1.25rem;
  margin-bottom: 30px;
}

.btn-login {
  display: inline-block;
  padding: 15px 30px;
  font-size: 1.2rem;
  background-color: #2575fc;
  color: #fff;
  border-radius: 5px;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

.btn-login:hover {
  background-color: #6a11cb;
}
</style>