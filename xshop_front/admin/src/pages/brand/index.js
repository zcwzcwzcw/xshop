import { connect } from 'dva';
import BrandList from '../../components/BrandList';

const Brand = ({ dispatch, brand }) => {
  function handleDelete(id) {
    dispatch({
      type: 'brand/delete',
      payload: id,
    });
  }
  return (
    <div>
      <h2>品牌管理</h2>
      <BrandList onDelete={handleDelete} brand={brand} />
    </div>
  );
};

export default connect(({ brand }) => ({
  brand,
}))(Brand);