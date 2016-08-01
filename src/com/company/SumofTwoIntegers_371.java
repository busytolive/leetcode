package com.company;

/**
 * 371. Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class SumofTwoIntegers_371
{
    /**
     * result of sum of two bits
     */
    class Result {
        public Result(int sum, boolean carryBit) {
            this.sum = sum;
            this.carryBit = carryBit;
        }
        public int sum;
        public boolean carryBit;
    }

    public int getSum(int a, int b) {
        int sum = 0;

        int currentBitOfA;
        int currentBitOfB;
        boolean carryBitFromLow = false;

        // calculate each bit(0 - 31) of sum
        for (int index = 0; index < 32; index++) {
            /**
             * Precedence of bit operators
             * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
             */
            // get the index bit of a
            currentBitOfA = a >>> index & 1;
            // get the index bit of b
            currentBitOfB = b >>> index & 1;
            // calculate the index bit of sum
            Result result = sumBit(currentBitOfA, currentBitOfB, carryBitFromLow);
            // update if there is bit to carry to next iteration
            carryBitFromLow = result.carryBit;
            // update value of sum
            sum = sum | (result.sum << index);
        }

        return sum;
    }

    /**
     * Calculate one bit of the sum
     * @param bit_1 bit value of one operand
     * @param bit_2 bit value of the other operand
     * @param carryBit do we have a carry bit from lower bit?
     * @return value of the bit of the sum and whether bit carried to higher bit.
     */
    private Result sumBit(int bit_1, int bit_2, boolean carryBit) {
        boolean hasCarryBit = false;
        if (bit_1 == 1 && bit_2 == 1) {
            hasCarryBit = true;
        } else if (!(bit_1 == 0 && bit_2 == 0) && carryBit) {
            hasCarryBit = true;
        }

        int sum = bit_1 ^ bit_2 ^ (carryBit ? 1 : 0);

        return new Result(sum, hasCarryBit);
    }
}

/**
 * Bit operations in Java:
 * http://www.tutorialspoint.com/java/java_bitwise_operators_examples.htm
 */
