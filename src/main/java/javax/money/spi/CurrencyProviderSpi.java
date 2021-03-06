/*
 * CREDIT SUISSE IS WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE
 * CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS AGREEMENT.
 * PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY
 * DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THE
 * AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY IT, SELECT THE "DECLINE"
 * BUTTON AT THE BOTTOM OF THIS PAGE.
 * 
 * Specification: JSR-354 Money and Currency API ("Specification")
 * 
 * Copyright (c) 2012-2014, Credit Suisse All rights reserved.
 */
package javax.money.spi;

import javax.money.CurrencyQuery;
import javax.money.CurrencyUnit;
import java.util.Set;

/**
 * SPI (core) to be registered using the {@link Bootstrap}, which allows to
 * register/provide additional currencies into the system automatically on
 * startup. The implementation is allowed to be implemented in y contextual way,
 * so depending on the runtime context, different currencies may be available.
 *
 * @author Anatole Tresch
 */
public interface CurrencyProviderSpi{


    /**
     * The unique name of this currency provider instance.
     * @return hte unique provider id, never null or empty.
     */
    String getProviderName();

    /**
     * CHecks if a {@link javax.money.CurrencyUnit} instances matching the given
     * {@link javax.money.CurrencyContext} is available from this provider.
     *
     * @param query the {@link javax.money.CurrencyQuery} containing the parameters determining the query. not null.
     * @return false, if no such unit is provided by this provider.
     */
    boolean isCurrencyAvailable(CurrencyQuery query);

    /**
     * Return a {@link javax.money.CurrencyUnit} instances matching the given
     * {@link javax.money.CurrencyContext}.
     *
     * @param query the {@link javax.money.CurrencyQuery} containing the parameters determining the query. not null.
     * @return the corresponding {@link javax.money.CurrencyUnit}s matching, never null.
     */
    Set<CurrencyUnit> getCurrencies(CurrencyQuery query);

}
