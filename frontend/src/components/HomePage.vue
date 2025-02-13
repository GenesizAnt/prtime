<template>
  <h2>Привет! Страница только для зареганых</h2>
  <a href="#" class="btn" v-if=store.getters.isAuthenticated v-on:click="logout">Logout </a>
</template>

<script>

export default {
  name: 'HomePage',
  data() {
    return {
      result: {},
      store: this.$store,
      user: {
        username: '',
        password: ''
      }
    }
  },
  created() {
  },
  mounted() {
    console.log("console.log(this.store.getters.isAuthenticated)");
    console.log(this.store.getters.isAuthenticated)
    console.log(2 + this.store.getters.isAdmin)
    console.log(3 + this.store.getters.getAuthorities)
    console.log(this.store.getters.getAuthorities === "user")
    console.log(5 + this.store.getters.getAuthorities === "ADMIN")
    console.log(6 + this.store.getters.getAuthorities)
  },
  methods: {
      logout() {
        console.log(1111)
        console.log(this.store.getters.isAuthenticated)
        this.$store.dispatch('logout');
        this.$router.push('/')
      }
  }
}
</script>

<style scoped>
/* Стили */
</style>