<script>
export default {
  computed: {
    isInTimePeriod() {    //在指定时间内开始考试
      const now = new Date();
      const hour = now.getHours();  // 获取当前小时
      const startHour = 9;  // 设定开始时间 9:00
      const endHour = 11;   // 设定结束时间 17:00

      return hour >= startHour && hour < endHour;  // 判断当前时间是否在工作时间内
    }
  }
};
</script>

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
    <div class="left">
      <span class="title">考试名称：</span>
      <span class="title">考试科目：</span>
      <span class="title">考试时长：</span>
      <span class="title">考试开始时间：</span>
    </div>
    <div class="right">
      <div class="no" v-if="isInTimePeriod">尚未到达考试时间~</div>
      <div class="yes" v-else>
        <div class="tips">
          线上考试须知：<br><br>
          &emsp;&emsp;考试时间：请考生按照安排准时登录考试系统，迟到超过15分钟将无法参加考试。<br>
          &emsp;&emsp;考试设备：确保设备正常运行，网络稳定。<br>
          &emsp;&emsp;考试环境：请在安静且无干扰的环境下参加考试。禁止使用手机、平板等其他电子设备，避免出现作弊行为。<br>
          &emsp;&emsp;答题要求：考试期间不得随意切换窗口、使用搜索引擎或其他辅助工具。如发现有违规行为，系统将自动记录并视为作弊。<br>
          &emsp;&emsp;考试结束：考试时间到时，系统将自动提交答卷，请考生确认答题完毕后按时提交。<br>
          &emsp;&emsp;技术支持：如遇到技术问题，请及时联系在线客服或技术支持，避免影响考试进度。<br>
        </div>
        <button class="entry">进入考试</button>
      </div>
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
  height: 600px;
  margin: 100px 200px;
  background-color: #f0f0f0;
  border: 5px solid lightgreen;
  border-radius: 20px;
}

.left{
  position: absolute;
  height:100%;
  width:50%;
  border-right: 5px solid lightgreen;
}

.title{
  display: inline-block;
  margin-left: 100px;
  margin-top: 30px;
  margin-right: 400px;
  font-size: 32px;
}

.right{
  display: flex;
  justify-content: center;
  position: absolute;
  height:100%;
  width:50%;
  margin-left:50%;
}

.right .no{
  font-size: 32px;
  margin-top:200px;
  color: darkgoldenrod;
}

.right .yes{
  display: flex;
  justify-content: center;
  align-items: center;
}

.right .tips{
  font-size: 24px;
  width: 400px;
  margin-right:50px;
  font-family: 楷体;
}

.right .entry{
  margin-left: 100px;
  background-color: white;
  border: 5px solid lightgreen;
  border-radius: 10px;
  font-size: 24px;
  font-weight: bold;
  height: 100px;
  width: 150px;
}

</style>