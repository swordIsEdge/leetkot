package easy

class IsPalindrome_9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var newValue = 0L
        var newX = x
        while (newX > 0) {
            newValue = newValue * 10 + newX % 10
            newX = newX / 10
        }
        return x.toLong()==newValue

    }
}