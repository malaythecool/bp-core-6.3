//
// HYBDeliveryMode.m
// [y] hybris Platform
//
// Copyright (c) 2000-2016 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//
// Warning:This file was auto-generated by OCC2Ojbc.
//

#import "HYBDeliveryMode.h"
#import "NSValueTransformer+MTLPredefinedTransformerAdditions.h"

#import "HYBPrice.h"


@implementation HYBDeliveryMode

+ (instancetype)deliveryModeWithParams:(NSDictionary*)params {

NSError *error = nil;
HYBDeliveryMode *object = [MTLJSONAdapter modelOfClass:[HYBDeliveryMode class] fromJSONDictionary:params error:&error];

if (error) {
    NSLog(@"Couldn't convert JSON to model HYBDeliveryMode");
    return nil;
}

return object;
}

+ (NSDictionary *)JSONKeyPathsByPropertyKey {
   return @{
@"code" : @"code",
@"name" : @"name",
@"descriptor" : @"description",
@"deliveryCost" : @"deliveryCost"
};
}




+ (NSValueTransformer *)deliveryCostJSONTransformer {
return [NSValueTransformer mtl_JSONDictionaryTransformerWithModelClass:[HYBPrice class]];
}



@end