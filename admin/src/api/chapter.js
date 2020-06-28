import request from '@/utils/request'

export function list(data) {
  return request({
    url: '/business/admin/list',
    method: 'post',
    data
  })
}
