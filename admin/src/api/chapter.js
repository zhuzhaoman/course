import request from '@/utils/request'

export function list(data) {
  return request({
    url: '/business/admin/list',
    method: 'post',
    data
  })
}

export function save(data) {
  return request({
    url: '/business/admin/save',
    method: 'post',
    data
  })
}
