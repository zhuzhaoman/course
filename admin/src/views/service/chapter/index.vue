<template>
  <el-table
    :data="chapter"
    border
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
</template>

<script>
  import { list } from "../../../api/chapter";
  export default {
    name: "index",
    data() {
      return {
        chapter: []
      }
    },
    mounted() {
      this.getList()
    },
    methods: {
      getList() {
        list({page: 2, size: 1}).then(res => {
          console.log(res)
          this.chapter = res.data.list
        })
      }
    }
  }
</script>

<style scoped>

</style>
