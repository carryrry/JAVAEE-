<script setup>

</script>

<template>
  <div class="top">
    <span class="first">基于教考分离的考试系统</span>
    <span>你好，</span>
  </div>
  <div class="nav">
    <ul>
      <li>首页</li>
      <li>个人信息</li>
      <li>考试安排</li>
      <li>收件箱</li>
    </ul>
  </div>
  <div class="main">
    <div class="left">
      <span class="title">个人信息</span>
      <ul>
        <li>&emsp;&emsp;学号：{{ }}</li>
        <li>&emsp;&emsp;姓名：{{ }}</li>
        <li>&emsp;&emsp;身份证号：{{ }}</li>
        <li>&emsp;&emsp;生日：{{ }}</li>
        <li>&emsp;&emsp;入学日期：{{ }}</li>
        <li>&emsp;&emsp;政治面貌：{{ }}</li>
        <li>&emsp;&emsp;籍贯：{{ }}</li>
        <li>&emsp;&emsp;联系方式：{{ }}</li>
      </ul>
    </div>
    <div class="right">
      <span class="title">学籍信息</span>
      <ul>
        <li>&emsp;&emsp;年级（入学年）：{{  }} 级</li>
        <li>&emsp;&emsp;学院：{{ }}</li>
        <li>&emsp;&emsp;专业名称：{{ }}</li>
        <li>&emsp;&emsp;专业方向：{{ }}</li>
        <li>&emsp;&emsp;班级：{{ }}</li>
        <li>&emsp;&emsp;学历层次：{{ }}</li>
      </ul>
    </div>
    <button>  问题反馈  </button>
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
  margin: 50px 100px;
  background-color: #f0f0f0;
  border: 5px solid lightgreen;
  border-radius: 20px;
}

ul{
  margin-top: 100px;
  list-style-type: none;
}

.title{
  position: absolute;
  margin-top: 20px;
  margin-left: 80px;
  font-size: 32px;
}

.left{
  position: absolute;
  width:50%;
  height:100%;
  border-right: 5px solid lightgreen;
}

li{
  margin: 20px 0;
  font-size: 24px;
}

.right{
  position: absolute;
  margin-left: 50%;
  width:50%;
  height:100%;
  border-right: 5px solid lightgreen;
}

button{
  position: absolute;
  height:70px;
  width:150px;
  font-size: 24px;
  color: cadetblue;
  border: 5px solid cadetblue;
  border-radius: 20px;
  bottom: 10px; /* 距离容器底部 10px */
  right: 10px; /* 距离容器右边 10px */
}

</style>