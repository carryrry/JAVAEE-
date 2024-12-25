<script setup>

</script>

<template>
  <div class="top">
    <span class="first">基于教考分离的考试系统</span>
    <span>你好，{{ username }}</span>
  </div>
  <div class="nav">
    <ul>
      <li><a href="#">首页</a></li>
      <li><a href="#">个人信息</a></li>
      <li><a href="#">考试安排</a></li>
      <li><a href="#">成绩查看</a></li>
      <li><a href="#">收件箱</a></li>
      <li><a href="#" class="feedback">问题反馈</a></li>
    </ul>
  </div>
  <div class="main">
    <div class="search">
      <span class="search-title">反馈记录</span>
      <button class="submit">提交反馈信息</button>
    </div>
    <div v-for="record in records" :key="record.id">
      <p class="record">{{ record.name }}</p>
    </div>
    <div class="pagination">
      <button @click="previousPage" :disabled="currentPage === 0">上一页</button>
      <span class="page">{{}} / {{}}</span>
      <button @click="nextPage" :disabled="currentPage === totalPages - 1">下一页</button>
    </div>
  </div>
</template>

<style scoped>
.top{
  background-color: lightgreen;
  margin-top: 0;
  padding: 10px 100px 0 100px;
  font-size: 32px;
  font-weight: bold;
  font-family: 华文楷体 ;
}
.top .first{
  margin-right: 1200px;
}

.nav{
  background: linear-gradient(to bottom,
  lightgreen 0%,        /* 上 20% 为 lightgreen */
  limegreen 30%,        /* 从 20% 开始到 80% 为 darkgreen */
  limegreen 70%,        /* 从 80% 到 100% 为 darkgreen */
  lightgreen 100%);     /* 下 20% 为 lightgreen */
  height: 60px;
}
.nav ul{
  display: flex;
  margin: 0;
}
.nav li{
  display: inline-block;
  margin:10px 50px 10px 100px;
  font-size: 24px;
}

.main{
  position: relative;
  display: flex;
  justify-content: center;
  height: 800px;
  margin: 50px 100px 100px;
  background-color: #f0f0f0;
  border: 5px solid lightgreen;
  border-radius: 20px;
}

.feedback{
  margin-left: 400px;
}

.search{
  display: flex;
  position: absolute;
  height: 100px;
  width: 100%;
  border-bottom: 5px solid lightgreen;
}

.search-title{
  margin-left: 100px;
  margin-top: 30px;
  margin-right: 400px;
  font-size: 32px;
}

.search .submit{
  height: 50px;
  width: 150px;
  margin-top: 30px;
  margin-left: 900px;
  font-size: 20px;
  border: 5px solid lightgreen;
  border-radius: 20px;
}

.record{
  display: flex;
  background-color: #f0f0f0;
}

.pagination{
  display: flex;
  justify-content: center;
  margin-top: 40%;
}

.pagination .page{
  font-size: 32px;
  margin:0 50px;
}

.pagination button{
  height: 60px;
  width: 100px;
  font-size: 24px;
  border: 5px solid lightgreen;
}
</style>