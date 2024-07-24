<template>
  <div>
    <h2>Приемы специалиста &larr;</h2>
    <ul>
      <li v-for="reception in receptions" :key="reception.id">
        {{ reception.receptionDate }} - {{ reception.receptionTime }} - {{ reception.id }}
        <button @click="getReceptionPage(reception.id)">Карточка приема</button>
        <button @click="openEditForm(reception)">Изменить встречу</button>
      </li>
    </ul>
    <div v-if="editingReceptions">




      //Todo добавить в ДТО id + проверить будет ли работать ДТО для создания встречи + сделать форму отправки данных




      <form @submit.prevent="editReception">
        <p>Hello</p>
        <p>{{ editingReceptions.id }}</p>
        <p>{{ editingReceptions.receptionDate }}</p>
        <p>{{ editingReceptions.receptionTime }}</p>
        <button type="submit">Update</button>
      </form>

    </div>
    <nav>
      <router-link to="/createReception">Назначить новый прием</router-link>
    </nav>
  </div>
</template>

<script>
import ReceptionAxios from '@/axios/ReceptionAxios';

export default {
  data() {
    return {
      receptions: [],
      editingReceptions: null
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
    },
    getReceptionPage(receptionId) {
      this.$router.push({
        name: 'ReceptionPage',
        params: {id: receptionId}
      });
    },
    openEditForm(reception) {
      this.editingReceptions = reception;
    },
    editReception() {
      console.log(42)
      this.editingReceptions = null;
    }
  }
};
</script>

<style scoped>

</style>