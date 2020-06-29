<template>
  <div class="container">

    <div class="top">
      <el-button type="primary" icon="el-icon-refresh" @click="handleRefresh()">刷新</el-button>
      <el-button type="primary" icon="el-icon-document-add" @click="handleAdd()">添加</el-button>
    </div>

    <!-- 表单 -->
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

    <!-- 分页 -->
    <div class="custom-pagination">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>

    <!-- 添加弹层 -->
    <el-dialog
      title="大章添加"
      :visible.sync="dialogVisible"
      width="50%">
      <el-form ref="chapterForm" :model="chapterForm" label-width="80px">
        <el-form-item label="课程名称">
          <el-input v-model="chapterForm.name"></el-input>
        </el-form-item>
        <el-form-item label="课程ID">
          <el-input v-model="chapterForm.courseId"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveChapter()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import { list, save } from "../../../api/chapter";
  export default {
    name: "index",
    data() {
      return {
        chapter: [],
        loading: true,
        page: 1,
        size: 5,
        total: 0,
        dialogVisible: false,
        chapterForm: { name: '', courseId: '' }
      }
    },
    mounted() {
      this.getList()
    },
    methods: {
      getList() {
        this.loading = true

        list({page: this.page, size: this.size}).then(res => {
          this.chapter = res.data.list
          this.total = res.data.total
          this.loading = false
        })
      },
      saveChapter() {
        let chapterForm = this.chapterForm
        if ((chapterForm.name.trim() === '') || (chapterForm.courseId.trim() === '')) {
          this.$message({
            message: '完善信息再提交！',
            type: 'warning'
          });
          return
        }

        // 关闭弹层
        this.dialogVisible = false

        // 保存数据
        save(this.chapterForm).then(res => {
          if (res.status === 200) {
            this.$message({
              message: '添加大章成功！',
              type: 'success'
            });
          } else {
            this.$message({
              message: res.msg,
              type: 'error'
            });
          }

          // 延迟更新列表
          this.getList()
        });

        // 清空数据
        this.chapterForm = { name: '', courseId: '' }
      },
      handleRefresh() {
        this.getList()
      },
      handleAdd() {
        this.dialogVisible = true
      },
      handleSizeChange(val) {
        this.size = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.page = val
        this.getList()
      }
    }
  }
</script>

<style lang="css" scoped>

  .top {
    padding: 10px;
  }

  .custom-pagination {
    padding: 20px;
  }
</style>
