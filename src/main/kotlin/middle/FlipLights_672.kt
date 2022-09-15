package middle

object FlipLights_672 {
    fun flipLights(n: Int, presses: Int): Int {
        var newPresses = presses
        if (newPresses > 4) {
            while (newPresses > 4) {
                newPresses -= 2
            }
            return flipLights(n, newPresses)
        } else {
            var tmp = 0
            while (newPresses >= 0) {
                tmp += flipLightsCore(n, newPresses)
                newPresses -= 2
            }
            return tmp
        }
    }

    fun flipLightsCore(n: Int, presses: Int): Int {
        return when (presses) {
            0 -> 1
            1 -> if (n <= 3) n + 1 else 4
            2 -> 0//?
            3 -> 0//?
            4 -> 1
            else -> 0

        }
    }
}