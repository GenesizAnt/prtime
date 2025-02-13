<template>
  <div id="app">
    <nav>
      <router-link to="/">Привет!</router-link>
      <span> | </span>
<!--      <router-link to="/allReceptionPage">Все приемы у специалиста</router-link>-->
<!--      <span> | </span>-->
      <router-link to="/allReceptionPage" v-if="this.store.getters.isAuthenticated">Admin!!!</router-link>
      <span> | </span>
      <router-link to="/admin" v-if="this.store.getters.isAuthenticated && this.store.getters.isAdmin">admin!</router-link>
      <h2>ss</h2>
      <h2>ss</h2>
      <router-link to="/login">Login</router-link>
      <br>
      <router-link to="/register">register!</router-link>
      <br><br><br><br>
      <a href="#" class="nav-link text-light" v-if="this.store.getters.isAuthenticated" v-on:click="logout">Logout </a>
      <br><br><br><br>
      <a href="#" class="btn" v-on:click="consolll">Данные в консоль</a>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      store: this.$store
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('logout');
      this.$router.push('/')
    },
    consolll() {
      console.log("console.log(this.store.getters.isAuthenticated)");
      console.log(this.store.getters.isAuthenticated)
      console.log(2 + this.store.getters.isAdmin)
      console.log(3 + this.store.getters.getAuthorities)
      console.log(this.store.getters.getAuthorities === "user")
      console.log(5 + this.store.getters.getAuthorities === "ADMIN")
      console.log(6 + this.store.getters.getAuthorities)
    }
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
