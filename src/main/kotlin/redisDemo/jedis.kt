package redisDemo

import redis.clients.jedis.Jedis

// 创建Redis客户端连接
val jedis = Jedis("localhost")

// 添加一个对象，并为其添加Tag
fun addObjectWithTags(objectId: String, tags: Set<String>) {
    // 将对象ID添加到每个Tag的集合中
    for (tag in tags) {
        jedis.sadd(tag, objectId)
    }
}

// 获取所有具有给定Tag的对象ID
fun getObjectsWithTag(tag: String): Set<String> {
    // 获取所有具有给定Tag的对象ID
    return jedis.smembers(tag)
}

// 获取具有所有给定Tag的对象ID的交集
fun getObjectsWithAllTags(tags: Set<String>): Set<String> {
    // 使用Redis的SINTER命令获取所有给定Tag的对象ID的交集
    val tagKeys = tags.toTypedArray()
    return jedis.sinter(*tagKeys)
}

// 获取具有任何一个给定Tag的对象ID的并集
fun getObjectsWithAnyTags(tags: Set<String>): Set<String> {
    // 使用Redis的SUNION命令获取所有给定Tag的对象ID的并集
    val tagKeys = tags.toTypedArray()
    return jedis.sunion(*tagKeys)
}

// 获取具有所有给定Tag的对象ID的差集
fun getObjectsWithoutTags(tags: Set<String>): Set<String> {
    // 获取所有具有第一个Tag的对象ID
    var result = getObjectsWithTag(tags.first())

    // 从结果中移除具有其它Tag的对象ID
    for (tag in tags.drop(1)) {
        result = result.minus(getObjectsWithTag(tag))
    }

    return result
}

// 将Tag名称按字母顺序添加到Sorted Set中，以便进行自动补全
fun addTagToAutoComplete(tag: String) {
    jedis.zadd("tag_autocomplete", 0.0, tag)
}

/**
 * 该功能可用于实现自动补全， zrangeByLex可以按照前缀获取members
 */
// 获取所有以指定前缀开头的Tag名称
fun getTagsStartingWith(prefix: String): Set<String> {
    // 使用Redis的ZRANGEBYLEX命令获取所有以指定前缀开头的Tag名称
    val min = "[$prefix"
    val max = "[${prefix}v"
    val result = jedis.zrangeByLex("tag_autocomplete", min, max)
    return result.toSet()
}
