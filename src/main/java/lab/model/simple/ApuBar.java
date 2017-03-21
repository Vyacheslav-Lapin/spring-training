package lab.model.simple;

import lab.CustomerBrokenException;
import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import lab.model.Squishy;
import org.springframework.stereotype.Component;

@Component
public class ApuBar implements Bar {

    @Override
	public Squishy sellSquishy(Customer customer)  {

	    if (customer.broke())
            throw new CustomerBrokenException();

        AopLog.append("Here is your Squishy \n");
        return new Squishy("Usual Squishy");
    }
}