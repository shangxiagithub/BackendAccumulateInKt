package redisDemo

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import redis.clients.jedis.Jedis

private const val KEY = "tag_autocomplete"

class JedisKtTest {

    private lateinit var dict: List<String>
    val jedis = Jedis("localhost")

    @BeforeEach
    fun setUp() {
        dict = listOf(
            "l",
            "lu",
            "luc",
            "luck",
            "lucky",
            "lucky*",
            "lun",
            "lunc",
            "lunch",
            "lunch*",
        )
        dict.map {
            jedis.zadd(KEY, 0.0, it)
        }
    }

//    @AfterEach
//    internal fun tearDown() {
//        jedis.zremrangeByLex(KEY, "[l", "[lv")
//    }

    @Test
    fun addObjectWithTags() {
    }

    @Test
    fun getObjectsWithTag() {
    }

    @Test
    fun getObjectsWithAllTags() {
    }

    @Test
    fun getObjectsWithAnyTags() {
    }

    @Test
    fun getObjectsWithoutTags() {
    }

    @Test
    fun addTagToAutoComplete() {

    }

    @Test
    fun getTagsStartingWith() {
        val tagsStartingWith = getTagsStartingWith("l")
        println(tagsStartingWith.toString())
    }
}