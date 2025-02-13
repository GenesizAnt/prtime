<template>
  <h2>Привет! Страница только для админа</h2>
</template>

<script>
import axios from 'axios';

export default {
  name: 'AdminPage',
  data () {
    return {
      user:{
        username: '',
        password: '',
        confirmPassword: '',
        email: ''
      },
      result: {}
    }
  },
  created() {
  },
  mounted() {
    console.log("mounted() called.......");
  },
  methods: {
    saveDate()
    {
      axios.post("http://localhost:8081/registration", this.user)
          .then(
              ({data})=>{
                console.log(data);
                try
                {
                  alert("Employee Registation Successfully");

                }
                catch(err)
                {
                  alert("failed");
                }
              }
          )
    }
  }
}
</script>

<style scoped>
/* Стили */
</style>