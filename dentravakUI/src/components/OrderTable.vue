<template>
  <div>
    <section class="hero is-primary">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Order
          </h1>
          <h2 class="subtitle">
            Overview
          </h2>
        </div>
      </div>
    </section>
    <div
      class="container"
      style="margin-top: 30px;"
    >
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
            <b-table-column
              field="id"
              label="ID"
              width="40"
              numeric
            >{{ props.row.id }}</b-table-column>
            <b-table-column
              field="creationDate"
              label="Date"
            >{{ props.row.creationDate }}</b-table-column>
            <b-table-column
              field="price"
              label="Price"
            >{{ props.row.price }}</b-table-column>
            <b-table-column
              field="mobilePhoneNumber"
              label="Mobile Phone"
            >{{ props.row.mobilePhoneNumber }}</b-table-column>
            <b-table-column
              field="sandwich"
              label="Sandwich"
            >{{ JSON.stringify(props.row.sandwich) }}</b-table-column>
          </template>

          <template slot="empty">
            <section class="section">
              <div class="content has-text-grey has-text-centered">
                <p>
                  <b-icon
                    icon="emoticon-sad"
                    size="is-large"
                  >
                  </b-icon>
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
  data () {
    return {
      data: [],
      isEmpty: false,
      isBordered: false,
      isStriped: false,
      isNarrowed: false,
      isHoverable: false,
      isFocusable: false,
      isLoading: false,
      hasMobileCards: true
    }
  },
  mounted () {
    let self = this
    fetch(location.protocol + '//' + location.hostname + ':8080/orders')
      .then(response => { return response.json() })
      .then(json => {
        self.data = json
        if (self.data.length === 0) {
          self.isEmpty = true
        }
      })
  }
}
</script>
