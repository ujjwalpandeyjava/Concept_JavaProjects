import React, { ReactPropTypes as PT } from 'react';
import { Comment, Divider, Grid } from 'semantic-ui-react';
import '../../util/mockComment.js';
import ProductCommentItem from './ProductCommentItem';

const propTypes = {
  dataComments: PT.array
}

const ProductComment = (props) => {

  const itemsComment = props.dataComments.map(function (item, index) {
    return (
      <ProductCommentItem
        key={item.id}
        {...item}
      />
    )
  })

  return (
    <Grid.Column width={12}>
      <Divider horizontal><span>Product Comment</span></Divider>
      <Comment.Group as='ul' id='comment-area' size='large'>
        {itemsComment}
      </Comment.Group>
    </Grid.Column>
  )
}

ProductComment.propTypes = propTypes;

export default ProductComment;