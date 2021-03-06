/*
 * CREDIT SUISSE IS WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE CONDITION THAT YOU
 * ACCEPT ALL OF THE TERMS CONTAINED IN THIS AGREEMENT. PLEASE READ THE TERMS AND CONDITIONS OF THIS
 * AGREEMENT CAREFULLY. BY DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF
 * THE AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY IT, SELECT THE "DECLINE" BUTTON AT THE
 * BOTTOM OF THIS PAGE. Specification: JSR-354 Money and Currency API ("Specification") Copyright
 * (c) 2012-2013, Credit Suisse All rights reserved.
 */
package javax.money.spi;

import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.Monetary;
import javax.money.MonetaryException;
import java.util.Collection;

/**
 * SPI (core) for the backing implementation of the {@link javax.money.Monetary} singleton. It
 * should load and manage (including contextual behavior), if needed) the different registered
 * {@link javax.money.MonetaryAmountFactory} instances.
 *
 * @author Anatole Tresch
 */
public interface MonetaryAmountsSingletonSpi{

    /**
     * Access the {@link javax.money.MonetaryAmountFactory} for the given {@code amountType} .
     *
     * @param amountType the {@link MonetaryAmount} implementation type, targeted by the factory.
     * @return the {@link javax.money.MonetaryAmountFactory}, or {@code null}, if no such
     * {@link javax.money.MonetaryAmountFactory} is available in the current context.
     */
    <T extends MonetaryAmount> MonetaryAmountFactory<T> getAmountFactory(Class<T> amountType);

    /**
     * Access the default {@link MonetaryAmount} implementation type.
     *
     * @return a the default {@link MonetaryAmount} type corresponding, never {@code null}.
     * @throws MonetaryException if no {@link MonetaryAmountFactoryProviderSpi} is available, or no
     *                           {@link MonetaryAmountFactoryProviderSpi} targeting the configured default
     *                           {@link MonetaryAmount} type.
     * @see Monetary#getDefaultAmountType()
     */
    Class<? extends MonetaryAmount> getDefaultAmountType();

    /**
     * Get the currently registered {@link MonetaryAmount} implementation types.
     *
     * @return the {@link java.util.Set} if registered {@link MonetaryAmount} implementations, never
     * {@code null}.
     */
    Collection<Class<? extends MonetaryAmount>> getAmountTypes();


    /**
     * Access the default {@link javax.money.MonetaryAmountFactory}.
     *
     * @return a the default {@link MonetaryAmount} type corresponding, never {@code null}.
     * @throws MonetaryException if no {@link MonetaryAmountFactoryProviderSpi} is available, or no
     *                           {@link MonetaryAmountFactoryProviderSpi} targeting the configured default
     *                           {@link MonetaryAmount} type.
     * @see Monetary#getDefaultAmountType()
     */
    MonetaryAmountFactory<?> getDefaultAmountFactory();

    /**
     * Get the currently registered {@link MonetaryAmount} implementation classes.
     *
     * @return the {@link java.util.Set} if registered {@link MonetaryAmount} implementations, never
     * {@code null}.
     */
    Collection<MonetaryAmountFactory<?>> getAmountFactories();

}