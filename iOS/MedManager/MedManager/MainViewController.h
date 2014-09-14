//
//  MainViewController.h
//  MedManager
//
//  Created by Glenn Sayers on 14/09/2014.
//  Copyright (c) 2014 Glenn Sayers. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MainViewController : UIViewController {
    IBOutlet UICollectionView * collectionView;
}

@property (nonatomic, retain) IBOutlet UICollectionView * collectionView;

@end
