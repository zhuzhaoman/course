<template>
  <div class="container">
    <el-button type="primary" icon="el-icon-refresh" @click="refresh()">刷新</el-button>
    <el-table
      :data="chapter"
      border
      v-loading="loading"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="ID">
      </el-table-column>
      <el-table-column
        prop="courseId"
        label="课程ID">
      </el-table-column>
      <el-table-column
        prop="name"
        label="大章名称">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="200">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import { list } from "../../../api/chapter";
  export default {
    name: "index",
    data() {
      return {
        chapter: [],
        loading: true
      }
    },
    mounted() {
      this.getList()
    },
    methods: {
      getList() {
        this.loading = true

        list({page: 2, size: 1}).then(res => {
          this.chapter = res.data.list
          this.loading = false
        })
      },
      refresh() {
        this.getList()
      }
    }
  }
</script>

<style scoped>

</style>
