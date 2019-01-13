<template>
  <div>
    <section class="hero is-primary">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">Recommendations</h1>
          <h2 class="subtitle">Overview</h2>
        </div>
      </div>
    </section>
    <div class="container" style="margin-top: 30px;">
      <div class="notification">
        <b-table
          :data="isEmpty ? [] : data"
          :bordered="isBordered"
          :striped="isStriped"
          :narrowed="isNarrowed"
          :hoverable="isHoverable"
          :loading="isLoading"
          :focusable="isFocusable"
          :mobile-cards="hasMobileCards"
        >
          <template slot-scope="props">
            <b-table-column field="id" label="ID" width="40" numeric>{{ props.row.id }}</b-table-column>
            <b-table-column field="name" label="Name">{{ props.row.name }}</b-table-column>
            <b-table-column field="price" label="Price">{{ props.row.price }}</b-table-column>
            <b-table-column field="ingredients" label="Ingredients">{{ props.row.ingredients }}</b-table-column>
            <b-table-column field="rating" label="Rating">{{ props.row.rating }}</b-table-column>

            <b-table-column label="Actions" centered>
              <button class="button is-small is-light" @click="order(props.row)">
                <b-icon icon="plus-box" type="is-success" size="is-medium"></b-icon>
              </button>
            </b-table-column>
          </template>

          <template slot="empty">
            <section class="section">
              <div class="content has-text-grey has-text-centered">
                <p>
                  <b-icon icon="emoticon-sad" size="is-large"></b-icon>
                </p>
                <p>Nothing here.</p>
              </div>
            </section>
          </template>
        </b-table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      data: [],
      isEmpty: true,
      isBordered: false,
      isStriped: false,
      isNarrowed: false,
      isHoverable: false,
      isFocusable: false,
      isLoading: false,
      hasMobileCards: true
    };
  },
  mounted() {
    let self = this;
    fetch(
      "http://193.191.177.8:10508/den-travak/getpreferences/" + "idefix@ucll.be"
    )
      .then(response => {
        return response.json();
      })
      .then(json => {
        let temp = json;
        Object.keys(temp).forEach(key => {
          let id = key;
          let rating = temp[key];

          fetch("http://193.191.177.8:10508/den-travak/sandwiches/" + id)
            .then(response => {
              return response.json();
            })
            .then(sandwich_json => {
              let ingredients = "";
              sandwich_json.ingredients.forEach(ingredient => {
                ingredients += ingredient.name + ", ";
              });
              ingredients = ingredients.slice(0, -2);
              sandwich_json.ingredients = ingredients;

              sandwich_json.price = "€ " + sandwich_json.price;
              sandwich_json.rating = rating;
              self.data.push(sandwich_json);
              self.data.sort(
                (a, b) => parseFloat(b.rating) - parseFloat(a.rating)
              );
              self.isEmpty = false;
            });
        });
      });
  },
  methods: {
    order(e) {
      window.location =
        "http://193.191.177.8:10508/den-travak-ui/index.html#/create_order?sandwich=" +
        e.id;
    }
  }
};
</script>
