/**
 * 空校验：null或者""都返回true
 * @param obj
 * @returns {boolean}
 */
export function isEmpty(obj) {
  if ((typeof obj === 'string')) {
    return !obj || obj.replace(/\s+/g,"") === ""
  } else {
    return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0)
  }
}

/**
 * 非空校验
 * @param obj
 * @returns {boolean}
 */
export function isNotEmpty(obj) {
  return !this.isEmpty()
}

/**
 * 长度校验
 * @param str
 * @param min
 * @param max
 * @returns {boolean|boolean}
 */
export function isLength(str, min, max) {
  return $.trim(str).length >= min && $.trim(str).length <= max
}
