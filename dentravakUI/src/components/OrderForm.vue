<template>
  <section class="section">
    <div class="container">
      <h1 class="title">Create Order</h1>
      <form
        ref="form"
        @submit.prevent="onSubmit"
      >
        <b-field label="Phonenumber">
          <b-input
            v-model="order.mobilePhoneNumber"
            required
          ></b-input>
        </b-field>

        <b-field label="Type">
          <b-select
            v-model="order.breadType"
            placeholder="Select a bread type"
            required
            expanded
          >
            <option
              v-for="option in bread_types"
              :key="option.id"
              v-bind:value="option.id"
            >
              {{ option.text }}
            </option>
          </b-select>
        </b-field>

        <b-field label="Sandwich">
          <b-select
            v-model="order.sandwich.id"
            placeholder="Select a sandwich"
            required
            expanded
            :disabled="$route.query.sandwich"
          >
            <option
              v-for="option in sandwiches"
              :key="option.id"
              v-bind:value="option.id"
            >
              Name: {{ option.name }}, Price: {{ option.price }}
            </option>
          </b-select>
        </b-field>

        <button
          class="button is-success"
          @click.prevent="onSubmit"
        >
          Create
        </button>
      </form>
    </div>
  </section>
</template>

<script>
export default {
  data () {
    return {
      order: {
        sandwich: {
          id: this.$route.query.sandwich
        }
      },
      bread_types: [
        { text: 'Turkish bread', id: 'TURKISH_BREAD' },
        { text: 'Wrap', id: 'WRAP' },
        { text: 'Boterhammekes', id: 'BOTERHAMMEKES' }
      ],
      sandwiches: []
    }
  },
  methods: {
    onSubmit () {
      let self = this
      fetch(location.protocol + '//' + location.hostname + ':8080/orders', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(self.order)
      }).then(request => {
        console.log(self.$route.params.sandwich)

        if (request.status === 201) {
          alert('Created succesfully.')
          window.location = location.protocol + '//' + location.hostname + ':8081/sandwich_overview'
        } else {
          alert('Failed to create.')
        }
      })
    }
  },
  mounted () {
    let self = this
    fetch(location.protocol + '//' + location.hostname + ':8080/sandwiches')
      .then(response => { return response.json() })
      .then(json => { self.sandwiches = json })
  }
}
</script>

<style scoped>
.container {
  text-align: left;
  max-width: 350px;
}
</style>
