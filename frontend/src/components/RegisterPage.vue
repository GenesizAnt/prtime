<template>
  <div class="card">
    <div class="card-header">Register Form</div>
    <div class="card-body">
      <form @submit.prevent="regist">
        <label>First Name</label>
        <input type="text" v-model="user.username" name="employeeName" id="employeeName" class="form-control">

        <label>Pass</label>
        <input type="password" v-model="user.password" name="password" id="password" class="form-control">

        <label>PassDobl</label>
        <input type="password" v-model="user.confirmPassword" name="confirmPassword" id="confirmPassword" class="form-control">

        <label>Email</label>
        <input type="email" v-model="user.email" name="email" id="email" class="form-control">

        <input type="submit" value="Save" class="btn btn-success">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'SignUp',
  data () {
    return {
      store: this.$store,
      user: {
        username: '',
        password: '',
        email: '',
        confirmPassword: ''
      },
      alertMessage: '',
    }
  },
  mounted() {
    console.log("22222222222");
    console.log(this.store.getters.isAuthenticated)
  },
  methods: {
    regist() {
      if (this.$data.user.username === '' || this.$data.user.username == null) {
        this.$data.alertMessage = 'Please, fill "Username" field';
        this.showAlert();
      } else if (this.$data.user.email === '' || this.$data.user.email == null) {
        this.$data.alertMessage = 'Please, fill "Email" field';
        this.showAlert();
      } else if (!this.$data.user.email.includes('@')) {
        this.$data.alertMessage = 'Email is incorrect';
        this.showAlert();
      } else if (this.$data.user.password === '' || this.$data.user.password == null) {
        this.$data.alertMessage = 'Please, fill "Password" field';
        this.showAlert();
      } else if (this.$data.user.confirmPassword === '' || this.$data.user.confirmPassword == null) {
        this.$data.alertMessage = 'Please, confirm password';
        this.showAlert();
      } else if (this.$data.user.confirmPassword !== this.$data.user.password) {
        this.$data.alertMessage = 'Passwords are not match';
        this.showAlert();
      } else {
        let newUser = {
          'username': this.$data.user.username,
          'email': this.$data.user.email,
          'password': this.$data.user.password,
          'confirmPassword': this.$data.user.confirmPassword
        };
        axios.post('http://localhost:8081/registration', newUser)
            .then(response => {
              console.log(response);
              this.successAlert();
            }, error => {
              this.$data.alertMessage = (error.response.data.message.length < 150) ? error.response.data.message : 'Request error. Please, report this error website owners'
              this.showAlert();
            })
            .catch(error => {
              console.log(error);
              this.$data.alertMessage = 'Request error. Please, report this error website owners';
              this.showAlert();
            });
      }
    },
    showAlert() {
      console.log("!!!!!!!!!!showAlert!!!!!!!!!!")
    },
    successAlert() {
      console.log("!!!!!!!!!!successAlert!!!!!!!!!!")
      this.username = '';
      this.email = '';
      this.password = '';
      this.confirmPassword = '';
    }
  }
}
</script>

<style scoped>
/* Стили */
</style>