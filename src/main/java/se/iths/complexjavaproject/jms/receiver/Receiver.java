package se.iths.complexjavaproject.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.complexjavaproject.jms.config.JmsConfig;
import se.iths.complexjavaproject.jms.model.MessageItem;
import se.iths.complexjavaproject.jms.model.OrderMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class Receiver {

    @JmsListener(destination = JmsConfig.ORDER_QUEUE)
    public void listen(@Payload OrderMessage orderMessage) {
        try {
            File newFile = new File("order-" + orderMessage.getId() + ".txt");
            double price = 0;
            if(newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            }
            FileWriter writer = new FileWriter(newFile.getName());
            writer.write("ORDER: " + orderMessage.getId());
            writer.write("\nDate: " + orderMessage.getLocalDateTime());
            writer.write("\nAddress: ");
            writer.write("\n" + orderMessage.getCustomer().getName());
            writer.write("\n" + orderMessage.getCustomer().getStreet());
            writer.write("\n" + orderMessage.getCustomer().getPostalCode());
            writer.write("\n" + orderMessage.getCustomer().getCity());
            writer.write("\n\nITEMS: ");
            if(orderMessage.getItems() != null) {
                for(MessageItem item : orderMessage.getItems()) {
                    writer.write("\n" + item.getName() + " - " + item.getPrice());
                    price += item.getPrice();
                }
            }
            writer.write("\nTotal price: " + price);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
