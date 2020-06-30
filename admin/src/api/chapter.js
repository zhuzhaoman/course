import request from '@/utils/request'

export function list(data) {
  return request({
    url: '/business/admin/chapter/list',
    method: 'post',
    data
  })
}

export function save(data) {
  return request({
    url: '/business/admin/chapter/save',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: '/business/admin/chapter/delete/' + id,
    method: 'delete'
  })
}
