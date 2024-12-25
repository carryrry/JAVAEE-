<template>
  <div class="top">
    <span class="first">基于教考分离的考试系统</span>
    <span>你好，</span>
  </div>
  <div class="nav">
    <ul>
      <li><a href="#">首页</a></li>
      <li><a href="#">个人信息</a></li>
      <li><a href="#">考试安排</a></li>
      <li><a href="#">成绩查看</a></li>
      <li><a href="#">收件箱</a></li>
    </ul>
  </div>
  <div class="main">
    <div class="search">
      <span class="search-title">考试记录</span>
      <span class="search-input">查询：</span>
      <select id="item" name="item" class="search-select">
        <option value="none"></option>
        <option value="course">课程</option>
        <option value="semester">学期</option>
      </select>
      <input type="text" class="search-name" id="search-name" name="search-name"><br><br>
    </div>
    <div v-for="record in records" :key="record.id">
      <p class="record">{{ record.name }}</p>
    </div>
    <div class="pagination">
      <button @click="previousPage" :disabled="currentPage === 0">上一页</button>
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
  height: 800px;
  margin: 50px 100px 100px;
  background-color: #f0f0f0;
  border: 5px solid lightgreen;
  border-radius: 20px;
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

.search-input{
  margin-left: 100px;
  margin-top: 30px;
  font-size: 24px;
}

.search-select{
  height: 50px;
  width: 130px;
  margin-top: 30px;
  padding-left: 10px;
  border: 3px solid darkgreen;
  border-radius: 20px;
  font-size: 24px;
}

.search-name {
  margin-top: 20px;
  margin-left: 100px;
  height: 50px;
  width: 200px;
  font-size: 24px;
  border: none; /* 移除所有边框 */
  border-bottom: 2px solid darkgreen; /* 只保留下边框 */
  background-color: transparent; /* 移除背景色 */
  padding: 5px 0; /* 设置内边距，调整上下距离 */
  outline: none; /* 移除焦点时的外边框 */
}

.record{
  display: flex;
  background-color: #f0f0f0;
}
</style>