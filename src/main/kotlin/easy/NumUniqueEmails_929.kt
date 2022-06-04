package easy

object NumUniqueEmails_929 {
    fun numUniqueEmails(emails: Array<String>): Int {
        if(emails.size<=1) return emails.size
        val results = hashSetOf<String>()
        for (email in emails) {
            val atIndex = email.indexOf('@')
            val uname = email.substring(0, atIndex)
            val hostName = email.substring(atIndex + 1, email.length)

            var unameWithoutPeriod= uname.replace(".","")
            val plusIndex = unameWithoutPeriod.indexOf('+')
            if (plusIndex > 0) {
               unameWithoutPeriod = unameWithoutPeriod.substring(0,plusIndex)
            }
            results.add("$unameWithoutPeriod@$hostName")

        }
        return results.size

    }
}