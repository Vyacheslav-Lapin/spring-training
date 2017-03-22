package lab.model.simple;

import lab.CustomerBrokenException;
import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class ApuBar implements Bar {

    @Override
	public SimpleSquishy sellSquishy(Customer customer)  {

	    if (customer.broke())
            throw new CustomerBrokenException();

        AopLog.append("Here is your SimpleSquishy\n");
        return new SimpleSquishy("Usual SimpleSquishy");
    }
}