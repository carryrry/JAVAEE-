import Vue, {createApp} from 'vue'
import student from './teacher/teacher_main.vue'  // 请确保 App.vue 存在并且路径正确

createApp(student).mount('#app')  // 将 Vue 实例挂载到 #app 元素上