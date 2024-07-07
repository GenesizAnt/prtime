<template>
  <div>
    <h2>Приемы специалиста</h2>
    <ul>
      <li v-for="reception in receptions" :key="reception.id">
        {{ reception.receptionDate }} - {{ reception.receptionTime }}
      </li>
    </ul>
  </div>
</template>

<script>
import ReceptionAxios from '@/axios/ReceptionAxios';

export default {
  data() {
    return {
      receptions: [],
    };
  },
  created() {
    this.fetchReceptions();
  },
  methods: {
    fetchReceptions() {
      ReceptionAxios.getAllReceptions().then(response => {
        this.receptions = response.data;
      })
    }
  }
};
</script>

<style scoped>

</style>