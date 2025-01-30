<template>
  <form @submit.prevent="login">
    <input v-model="username" placeholder="Username" />
    <input v-model="password" type="password" placeholder="Password" />
    <button type="submit">Login</button>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
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
        console.error('Login failed', error);
        alert('Login failed. Please check your credentials.'); // Показываем сообщение об ошибке
      }
    },
  },
};
</script>