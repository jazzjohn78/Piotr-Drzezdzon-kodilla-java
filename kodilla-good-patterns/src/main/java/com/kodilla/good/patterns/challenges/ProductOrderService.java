package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderProcessor orderProcessor;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService, final OrderProcessor orderProcessor, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderProcessor = orderProcessor;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final ProductOrder productOrder) {
        boolean isOrdered = orderProcessor.order(productOrder.getUser(), productOrder.getProduct(), productOrder.getQuantity());

        if(isOrdered) {
            informationService.inform(productOrder.getUser());
            orderRepository.createOrder(productOrder.getUser(), productOrder.getProduct(), productOrder.getQuantity());
            return new OrderDto(productOrder.getUser(), true);
        } else {
            return new OrderDto(productOrder.getUser(), false);
        }
    }
}
