package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;
    //test to check for greatest common divisor
    public int GCD(int numerator, int denominator) {

        if (denominator == 0)
        {
            return numerator;
        }
        else{
            return GCD(denominator, numerator%denominator);
        }


    }
    public void sign()
    {   // test to check what sign should the numerator and denominator carry
        if (denominator < 0)
        {
            this.denominator = (-1)*(denominator);
            if (numerator < 0)
            {
                this.numerator = (-1)*(numerator);
            }
            else
            {
                this.numerator = (-1)*(numerator);
            }
        }
    }
    public FractionImpl(int numerator, int denominator) { //test for fraction
        // TODO
        if(denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }


        int divisor = GCD(numerator,denominator);
        this.numerator = numerator/divisor;
        this.denominator = denominator/divisor;




    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) { //test to check representation of whole numbers
        // TODO
        this.numerator = wholeNumber;
        this.denominator = 1;

    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // TODO
        String results = "";

        for (int i = 0; i < fraction.length(); i++)
        {

            String c = fraction.substring(i, i+1);

            if (c.equals(" "))
            {
                System.out.print(c.trim());
            }
            else
            {
                results = results + c;
            }
        }
            if(results.contains("/"))
            {
                String[] n = results.split("/");
                this.numerator = Integer.parseInt(n[0]);
                this.denominator = Integer.parseInt(n[1]);
                if(this.denominator == 0)
                {
                    throw new ArithmeticException("Divide by zero");
                }
                else
                {
                this.denominator = Integer.parseInt(n[1]);
                }

            }
            else
            {
                int k = Integer.parseInt(results);
                FractionImpl y = new FractionImpl(k);
                this.numerator = y.numerator;
                this.denominator = y.denominator;

            }

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {

        int a = this.numerator;
        int b = this.denominator;
        int c = ((FractionImpl)f).numerator;
        int d = ((FractionImpl)f).denominator;
        int fractionNumerator = ((a*d)+(b*c));
        int fractionDenominator = (b*d);


        return new FractionImpl(fractionNumerator,fractionDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {

        int a = this.numerator;
        int b = this.denominator;
        int c = ((FractionImpl)f).numerator;
        int d = ((FractionImpl)f).denominator;
        int fractionNumerator = ((a*d)-(b*c));
        int fractionDenominator = (b*d);

        return new FractionImpl(fractionNumerator,fractionDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {

        int a = this.numerator;
        int b = this.denominator;
        int c = ((FractionImpl)f).numerator;
        int d = ((FractionImpl)f).denominator;
        int fractionNumerator = (a*c);
        int fractionDenominator = (b*d);

        return new FractionImpl(fractionNumerator,fractionDenominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {

        int a = this.numerator;
        int b = this.denominator;
        int c = ((FractionImpl)f).numerator;
        int d = ((FractionImpl)f).denominator;
        int fractionNumerator = (a*d);
        int fractionDenominator = (b*c);

        return new FractionImpl(fractionNumerator,fractionDenominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        if (this.numerator < 0 )
        {
            this.numerator = (-1) * numerator;

        }
        else if (this.denominator < 0)
        {
            this.denominator = (-1) * denominator;
        }
        else if (this.denominator > 0)
        {
            this.denominator = (1) * denominator;
        }
        if (this.numerator < 0 )
        {
            this.numerator = (1) * numerator;

        }
        return new FractionImpl(this.numerator,this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        if (this.numerator < 0 )
        {
            this.numerator = (-1) * numerator;

        }
        else if (this.denominator < 0)
        {
            this.denominator = (-1) * denominator;
        }
        else if (this.denominator > 0)
        {
            this.denominator = (-1) * denominator;
        }
        if (this.numerator > 0 )
        {
            this.numerator = (-1) * numerator;

        }
        return new FractionImpl(this.numerator,this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Fraction){
            return super.equals(obj);
        }
        else
        {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse()
    {
        return new FractionImpl(this.denominator, this.numerator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o)
    {
        int numerator_0 = ((FractionImpl)o).numerator;
        int denominator_O = ((FractionImpl)o).numerator;
        int thisNumerator = this.numerator;
        int thisDenominator = this.denominator;
        float thisResults = (float)thisNumerator/(float)thisDenominator;
        float Results_O = (float)numerator_0/(float)denominator_O;

        if (thisResults == 0)
        {
            return 0;
        }
        if (thisResults > Results_O)
        {
            return 1;
        }
        else
        {
            return  -1;
        }


    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        int n = this.numerator;
        int d = this.denominator;

        if (this.numerator == 0)
        {
            return "0" + "/" + "1";
        }
        else if (d == 1)
        {

            return String.valueOf(n);
        }
        else if (this.numerator < 0 || this.denominator <0)
        {
            this.sign();
            int num = this.numerator;
            int dem = this.denominator;
            String numString = String.valueOf(num);
            String demString = String.valueOf(dem);

            return numString + "/" + demString;

        }

        else
        {
            String numString = String.valueOf(n);
            String demString = String.valueOf(d);

            return numString + "/" + demString;
        }

    }
}