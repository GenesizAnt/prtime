<template>
  <div>
    <input type="text" v-model="user.username" placeholder="Username" />
    <input type="password" v-model="user.password" placeholder="Password" />
    <button @click="login">Login</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: 'LoginPage',
  data() {
    return {
      result: {},
      alertMessage: 'Request error',
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    async login() {
      console.log(1111111);
      try {
        const response = await axios.post('http://localhost:8081/receptions/api/auth/login', {
          username: this.username,
          password: this.password,
        });
        console.log(response.data);
        localStorage.setItem('token', response.data); // Сохраняем токен в localStorage
        this.$router.push('/'); // Перенаправляем на главную страницу
      } catch (error) {
        if (error.code === 'ERR_NETWORK') {
          console.error('Network error:', error.message);
        } else {
          console.error('Error:', error.message);
        }
        console.error('Login failed', error);
        alert('Login failed. Please check your credentials.'); // Показываем сообщение об ошибке
      }
    },
  },
};
</script>

<style scoped>
/* Стили */
</style>