//
//  LoginViewController.m
//  MedManager
//
//  Created by Glenn Sayers on 14/09/2014.
//  Copyright (c) 2014 Glenn Sayers. All rights reserved.
//

#import "LoginViewController.h"
#import "MainTableViewController.h"
#import "SVProgressHUD.h"
#import "AFNetworking.h"
@interface LoginViewController ()
-(void) loginUser;
@end

@implementation LoginViewController
@synthesize userIdField, passwordField, loginButton;

- (void)viewDidLoad {
    [super viewDidLoad];
    [self setUpUI];
    self.title = @"Login";
    [self.passwordField setSecureTextEntry:YES];
    [self.loginButton addTarget:self action:@selector(loginUser) forControlEvents:UIControlEventTouchUpInside];
    self.navigationItem.hidesBackButton = YES;

    // Do any additional setup after loading the view from its nib.
}

-(void) loginUser {
    [SVProgressHUD showWithMaskType:SVProgressHUDMaskTypeGradient];
    NSMutableDictionary * loginDetails = [[NSMutableDictionary alloc] init];
    [loginDetails setObject:self.userIdField.text forKey:@"id"];
    [loginDetails setObject:self.passwordField.text forKey:@"password"];
    AFHTTPRequestOperationManager * manager = [AFHTTPRequestOperationManager manager];
    
    /** Set the request url and request body **/
    [manager POST:@"http://10.10.10.177:9000/mobile/login" parameters:loginDetails success:^(AFHTTPRequestOperation *operation, id responseObject) {
        
        if([responseObject valueForKey:@"success"]) {
            MainTableViewController * mainVC = [[MainTableViewController alloc] initWithStyle:UITableViewStylePlain];
            [self.navigationController pushViewController:mainVC animated:YES];
        } else {
            
        }
        
        [SVProgressHUD dismiss];
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"%@", error);
        [SVProgressHUD dismiss];

    }];

    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) setUpUI {
    [self.navigationController.navigationBar setBarTintColor:
     [UIColor colorWithRed:102.0f/255.0f green:194.0/255.0f blue:102.0/255.0f alpha:1.0f]];

    self.navigationController.navigationBar.tintColor = [UIColor whiteColor];
    
    /** Set the nav bar font colour, fontface and size **/
    [self.navigationController.navigationBar setTitleTextAttributes:@{NSForegroundColorAttributeName : [UIColor whiteColor],NSFontAttributeName: [UIFont fontWithName:@"OpenSans-Light" size:20.0f]}];

    
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
