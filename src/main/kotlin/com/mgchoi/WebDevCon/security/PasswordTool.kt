package com.mgchoi.WebDevCon.security

import java.security.MessageDigest
import kotlin.random.Random

class PasswordTool {

    companion object {

        fun encryptPassword(userPW: String, salt: String): String {
            val messageDigest = MessageDigest.getInstance("SHA-256")

            var result = userPW + salt

            for (i in 0 until 5) {
                messageDigest.update(result.toByteArray())
                result = bytesToHex(messageDigest.digest())
            }

            return result
        }

        private fun bytesToHex(bytes: ByteArray): String {
            val builder = StringBuilder()
            for (b in bytes) {
                builder.append(String.format("%02x", b))
            }
            return builder.toString()
        }

    }

    class SaltGenerator {

        companion object {
            private val charPool: List<Char> =
                ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf<Char>('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_')

            fun generate(length: Int = 10): String {
                val builder = StringBuilder()

                for (i in 0 until length) {
                    val index = Random.nextInt(0, charPool.size)
                    builder.append(charPool[index])
                }

                return builder.toString()
            }
        }

    }

}