<script setup>

</script>

<template>
  <div class="top">
    <span class="first">基于教考分离的考试系统——学生端</span>
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
    <div class="left">
      <ul>
        <li>{{name}}</li>
        <li>{{sid}}</li>
        <li>{{_class}}</li>
      </ul>
    </div>
    <div class="test">
      <ul>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <div class="score">

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
  margin-right: 1100px;
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
.nav li a{

}

.main{
  position: relative;
  display: flex;
  height: 800px;
  margin: 100px 200px;
  background-color: #f0f0f0;
  border: 5px solid lightgreen;
  border-radius: 20px;
}

.left{
  position: absolute;
  width:20%;
  height:100%;
  border-right: 5px solid lightgreen;
}

.test{
  position: absolute;
  margin-left: 20%;
  width:40%;
  height:100%;
  border-right: 5px solid lightgreen;
}
</style>