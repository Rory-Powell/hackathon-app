//
//  MainViewController.m
//  MedManager
//
//  Created by Glenn Sayers on 14/09/2014.
//  Copyright (c) 2014 Glenn Sayers. All rights reserved.
//

#import "MainViewController.h"
#import "AFHTTPRequestOperationManager.h"
#import "SVProgressHUD.h"
@interface MainViewController ()

@end

@implementation MainViewController
@synthesize collectionView;
- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.hidesBackButton = YES;
    self.title = @"Overview";
    
    [self fetchBedData];
    // Do any additional setup after loading the view from its nib.
}

-(void) fetchBedData {
    
    [SVProgressHUD showWithMaskType:SVProgressHUDMaskTypeGradient];
    AFHTTPRequestOperationManager * manager = [AFHTTPRequestOperationManager manager];
    
    /** Set the request url and request body **/
    [manager GET:@"http://10.10.10.177:9000/mobile/allBeds" parameters:nil success:^(AFHTTPRequestOperation *operation, id responseObject) {
        
        if([responseObject valueForKey:@"success"]) {
            UIImageView * view = [[UIImageView alloc] initWithFrame:CGRectMake(0, 0, 100, 100)];
            [view setImage:[UIImage imageNamed:@"bed.png"]];
            [view setBackgroundColor:[UIColor redColor]];
            [self.collectionView addSubview:view];
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

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
