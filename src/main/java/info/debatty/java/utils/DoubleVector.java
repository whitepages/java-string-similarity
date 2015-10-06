/*
 * The MIT License
 *
 * Copyright 2015 tibo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package info.debatty.java.utils;

/**
 *
 * @author tibo
 */
public class DoubleVector {
    protected double[] values;
    
    public DoubleVector() {
        
    }

    /**
     * 
     * @param array 
     */
    public DoubleVector(double[] array) {
        
        this.values = array;
    }
    
    
    /**
     * 
     * @param other
     * @return 
     */
    public double dotProduct(DoubleVector other) {
        double agg = 0;

        for (int i = 0; i < values.length; i++) {
            agg += this.values[i] * other.values[i];
        }
        return agg;
    }
    
    public double dotProduct(double[] other) {
        double agg = 0;
        for (int i = 0; i < values.length; i++) {
            agg += other[i] * values[i];
        }
        return agg;
    }
    
    
    
    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < values.length; i++) {
            r += values[i] + " ";
        }
        
        return r;
    }

    /**
     * Return the number of (non-zero) elements in this vector.
     * @return 
     */
    public int size() {
        return values.length;
    }
    
    /**
     * Compute and return the L2 norm of the vector
     * @return 
     */
    public double norm() {
        
        double agg = 0;
        for (int i = 0; i < values.length; i++) {
            agg += values[i] * values[i];
        }
        return Math.sqrt(agg);
    }
    
    /**
     * 
     * @param other
     * @return 
     */
    
    public double cosineSimilarity(DoubleVector other) {
        
        return this.dotProduct(other) / (this.norm() * other.norm());
        
    }
    
    
    public double[] toArray() {
        return this.values;
    }
    
    public static DoubleVector fromSphericalCoordinates(double r, double[] theta) {
        double[] x = new double[theta.length + 1];
        double agg = r;
        
        for (int i = 0; i < theta.length; i++) {
            x[i] = agg * Math.cos(theta[i]);
            agg *= Math.sin(theta[i]);
        }
        x[theta.length] = agg;
        
        return new DoubleVector(x);
    }
}
