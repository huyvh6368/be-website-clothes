package web.clothes.mapper;

import web.clothes.dto.request.AddressRequest;
import web.clothes.dto.response.AddressResponse;
import web.clothes.entity.Address;
import web.clothes.entity.Customer;

public class AddressMapper {
    public static Address addRequestToEntity(AddressRequest request, Customer customer) {
        return Address.builder()
                .customer(customer)
                .receiver(request.getReceiver())
                .phoneNumber(request.getPhoneNumber())
                .province(request.getProvince())
                .district(request.getDistrict())
                .ward(request.getWard())
                .address(request.getAddress())
                .addressDefault(request.getAddressDefault())
                .build();
    }

    public static Address updateRequestToEntity(AddressRequest request, Customer customer, Long id) {
        Address address = new Address();
        address.setId(id);
        address.setCustomer(customer);
        address.setReceiver(request.getReceiver());
        address.setPhoneNumber(request.getPhoneNumber());
        address.setProvince(request.getProvince());
        address.setDistrict(request.getDistrict());
        address.setWard(request.getWard());
        address.setAddress(request.getAddress());
        address.setAddressDefault(request.getAddressDefault());
        return address;
    }

    public static AddressResponse entityToResponse(Address entity) {
        return AddressResponse.builder()
                .id(entity.getId())
                .receiver(entity.getReceiver())
                .phoneNumber(entity.getPhoneNumber())
                .province(entity.getProvince())
                .district(entity.getDistrict())
                .ward(entity.getWard())
                .address(entity.getAddress())
                .addressDefault(entity.getAddressDefault())
                .build();
    }
}
