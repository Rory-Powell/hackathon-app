//
//  LoginViewController.h
//  MedManager
//
//  Created by Glenn Sayers on 14/09/2014.
//  Copyright (c) 2014 Glenn Sayers. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LoginViewController : UIViewController {
    IBOutlet UITextField *userIdField;
    IBOutlet UITextField *passwordField;
    IBOutlet UIButton *loginButton;
}

@property (nonatomic, retain) IBOutlet UITextField *userIdField;
@property (nonatomic, retain) IBOutlet UITextField *passwordField;
@property (nonatomic, retain) IBOutlet UIButton *loginButton;

@end
