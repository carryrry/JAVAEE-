<template>
  <div id="title" class="title">基于教考分离的考试系统</div>
  <div id="box" class="box">
    <div class="left"></div>
    <div class="right">
      <h4>登 录</h4>
      <form @submit.prevent="login">
        <input
            class="acc"
            type="text"
            id="username"
            name="username"
            placeholder="用户名"
            required
        />
        <input
            class="acc"
            type="password"
            id="password"
            name="password"
            placeholder="密码"
            required
        />

        <input class="acc" type="text" v-model="phone" id="phone" placeholder="手机号" />

        <div class="form-container">
          <input class="acc" type="text" v-model="captcha" id="captcha" placeholder="验证码" />
          <button class="buttons" @click="sendCaptcha" :disabled="isSending">发送验证码</button>

          <span v-if="isSending" class="countdown">
            <span>{{ countdown }}秒后重新发送</span>
          </span>
        </div>

        <input class="submit" type="submit" value="登录" />
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      name: 'App',
      phone: '',
      captcha: '',
      countdown: 0, // 倒计时秒数
      isSending: false, // 是否正在发送验证码
    };
  },
  methods: {
    // 发送验证码的模拟方法
    sendCaptcha() {
      if (!this.phone) {
        alert('请输入手机号');
        return;
      }

      this.isSending = true;
      this.countdown = 60; // 设置倒计时60秒

      axios.post('http://localhost:8080/send_captcha', {
        username: this.username,
        password: this.password,
        phone: this.phone,
        captcha: this.captcha,
      })
      setTimeout(() => {
        alert('验证码已发送');
      }, 1000);

      // 启动倒计时
      const interval = setInterval(() => {
        if (this.countdown === 0) {
          clearInterval(interval);
          this.isSending = false;
        } else {
          this.countdown--;
        }
      }, 1000);
    },

    // 登录功能
    login() {
      // 判断是否填写了必要字段
      if (!this.username || !this.password || !this.phone || !this.captcha) {
        alert('请填写所有字段');
        return;
      }

      // 发送登录请求到后端
      axios.post('http://localhost:8080/login', {
        username: this.username,
        password: this.password,
        phone: this.phone,
        captcha: this.captcha,
      })
          .then(response => {
            if (response.data.success) {
              alert('登录成功');
              // 登录成功后，可以跳转到主页或其他页面
              // this.$router.push('/home');
            } else {
              alert('登录失败: ' + response.data.message);
            }
          })
          .catch(error => {
            console.error('登录请求失败', error);
            alert('登录失败，请稍后再试');
          });
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html {
  font-size: 10px;
}

html::before {
  /* 定义了一个伪元素::before，应用于html元素 */
  content: ""; /* 设置伪元素的内容为空。伪元素必须有content属性，才能显示 */
  width: 100%; /* 设置伪元素的宽度为其包含块（即整个页面）的100% */
  height: 100%; /* 设置伪元素的高度为其包含块（即整个页面）的100% */
  position: fixed; /* 设置伪元素的定位方式为固定定位。固定定位的元素相对于浏览器窗口进行定位，即使页面滚动，它们也会保持在同一个位置 */
  z-index: -1; /* 设置伪元素的堆叠顺序 */
  background: linear-gradient(120deg, #3fe363 0%, #8ec5fc 50%, #3fe363 100%)
  no-repeat; /* 设置伪元素的背景为一个线性渐变，起始角度为120度 */
}

::selection {
  /* 选中文字 */
  color: #fff;
  background-color: rgb(19, 19, 240);
}

.title{
  text-align: center; /* 水平居中 */
  font-size: 32px;
  margin-top: 3rem;
  color: darkgreen;
}

.box {
  display: flex; /* flex布局 */
  overflow: hidden; /* 当子元素内容超过容器大小时，超出的部分将被隐藏 */
  width: 100rem; /* 设置元素的宽度为100个rem（root em）单位，1rem通常等于根元素（通常是html）的字体大小 */
  height: 50rem; /* 设置元素的高度为50个rem单位 */
  background-color: rgba(
      230,
      230,
      230,
      60%
  ); /* 设置背景颜色为白色，并带有60%的不透明度 */
  border-radius: 1.5rem; /* 设置元素的边框圆角半径为1.5rem，使其有圆角效果 */
  margin: 3% auto; /* 设置元素的外边距为上下各10%，左右自动。这样可以在垂直方向上有一定距离，同时水平居中 */
  box-shadow: 0 0 1rem 0.2rem rgba(0, 0, 0, 0.1); /* 设置一个阴影效果。阴影的偏移量为0（即没有偏移），模糊半径为1rem，扩展半径为0.2rem，颜色为10%不透明度的黑色。 */
}

.box .left {
  position: relative; /* 设置元素的定位方式为相对定位。这意味着该元素的位置可以通过 top、right、bottom 和 left 属性进行调整，相对于其正常位置进行偏移 */
  width: 60%; /* 设置元素的宽度为其父容器（即.box容器）宽度的60%。 */
  height: 100%; /* 设置元素的高度为其父容器（即.box容器）高度的100%。 */
  background-color: skyblue;
}

.box .left::before {
  /* 设置图片 */
  content: "";
  position: absolute; /* 设置伪元素的定位方式为绝对定位。绝对定位的元素相对于其最近的已定位祖先元素进行定位 */
  width: 100%;
  height: 100%;
  background-image: url(../image/work.jpg);
  background-size: cover;
  opacity: 100%; /* 设置伪元素的透明度为100% */
}

.box .right {
  display: flex;
  width: 40%;
  border-radius: 1.5rem; /* 设置元素的边框圆角半径为1.5rem，使其有圆角效果 */
  border: 1px;
  flex-direction: column; /* 设置flex容器内的子元素排列方向为列方向 */
  align-items: center;
}

.box .right h4 {
  /* 应用于.box .right元素内的所有h4元素 */
  color: rgb(38, 185, 249); /* 设置文本颜色为RGB值rgb(144, 129, 241) */
  font-size: 3rem; /* 设置字体大小为3rem（root em）单位 */
  margin-top: 2rem; /* 设置元素的上外边距为5rem */
}

.box .right form {
  display: flex;
  flex-wrap: wrap; /* 允许flex容器内的子元素（即表单内的各个表单元素）在容器中换行 */
  justify-content: center; /* 设置flex容器内的子元素在主轴（即水平轴）上的对齐方式为居中对齐 */
}

.box .right form .acc {
  outline: none; /* 移除元素的轮廓 */
  width: 80%; /* 设置元素的宽度为其父容器宽度的80% */
  height: 2rem;
  font-size: 1.2rem; /* 设置元素的字体大小为1.6rem */
  margin-top: 5rem; /* 设置元素的上外边距为5rem */
  padding: 0 0 0 1.6rem; /* 设置元素的内边距（内容与边框之间的空间）。上边距为1rem，右边距为0，下边距为0，左边距为1.6rem */
  border: none; /* 移除元素的边框 */
  border-bottom: 1px solid rgb(38, 185, 249); /* 设置元素底部的边框为1px宽，实线，颜色为rgb(38, 185, 249) */
  color: rgb(40, 21, 249); /* 设置元素文本的颜色为rgb(40, 21, 249) */
  background-color: rgba(0, 0, 0, 0); /* 设置元素的背景颜色为透明 */
}

.form-container {
  display: flex;
  align-items: center; /* 垂直居中对齐 */
  gap: 10px; /* 组件间的间隔 */
}

/* 输入框样式 */
.form-container .acc {
  outline: none; /* 移除元素的轮廓 */
  width: 50%; /* 设置元素的宽度为其父容器宽度的80% */
  height: 2rem;
  font-size: 1.2rem; /* 设置元素的字体大小为1.6rem */
  margin-top: 5rem; /* 设置元素的上外边距为5rem */
  padding: 0 0 0 1.6rem; /* 设置元素的内边距（内容与边框之间的空间）。上边距为1rem，右边距为0，下边距为0，左边距为1.6rem */
  border: none; /* 移除元素的边框 */
  border-bottom: 1px solid rgb(38, 185, 249); /* 设置元素底部的边框为1px宽，实线，颜色为rgb(38, 185, 249) */
  color: rgb(40, 21, 249); /* 设置元素文本的颜色为rgb(40, 21, 249) */
  background-color: rgba(0, 0, 0, 0); /* 设置元素的背景颜色为透明 */
}

/* 按钮的容器 */
.form-container .buttons {
  display: inline;
  width: 40%;
  height: 2rem;
  color: #ffffff; /* 设置元素文本的颜色为#f6f6f6 */
  background-image: linear-gradient(150deg, #14d6f8 0%, #27fc58 100%);
  font-size: 1.4rem;
  border: none;
  border-radius: 0.5rem; /* 设置元素的边框圆角半径为0.5rem */
  margin: 3rem 0 0 5rem; /* 设置元素的外边距，上边距为6rem，左边距为父容器宽度的50% */
  transform: translateX(
      -50%
  ); /* 使用CSS变换属性将元素在X轴上左移50%，使元素在水平方向上完全居中 */
}

/* 倒计时文本的样式 */
.form-container .countdown {
  margin-top: 10px;
  color: black;
  font-size: 18px;
}

.right .submit {
  width: 60%;
  height: 5rem;
  color: #ffffff; /* 设置元素文本的颜色为#f6f6f6 */
  background-image: linear-gradient(150deg, #14d6f8 0%, #27fc58 100%);
  font-size: 1.4rem;
  border: none;
  border-radius: 0.5rem; /* 设置元素的边框圆角半径为0.5rem */
  margin: 3rem 0 0 50%; /* 设置元素的外边距，上边距为6rem，左边距为父容器宽度的50% */
  transform: translateX(
      -50%
  ); /* 使用CSS变换属性将元素在X轴上左移50%，使元素在水平方向上完全居中 */
}

.right .submit:hover {
  box-shadow: 0 0 2rem -0.5rem rgb(0 0 0 / 15%);
}

.right .fn {
  display: flex;
  justify-content: space-between; /* 设置flex容器内的子元素在主轴上的对齐方式为两端对齐 */
  margin-top: 8rem; /* 设置元素的上外边距为1rem */
  width: 50%;
}

.right .fn a {
  font-size: 1.3rem;
  color: #666;
}

.right .fn a:hover {
  color: rgb(6, 155, 71);
}
</style>
