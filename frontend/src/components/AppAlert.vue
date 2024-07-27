<template>
  <div v-if="alert" class="alert" :class="alert.type">
    <h3>{{ alert.title }}</h3>
    <div v-if="alert.text">
      <p v-for="message in alert.text" :key="message">
        {{ message }}
      </p>
    </div>
    <button class="btn" :class="alert.type" @click="$emit('close')">Закрыть</button>
  </div>
</template>

<script>
export default {
  emits: ['close'],
  props: ['alert']
}
</script>

<style scoped>

</style>